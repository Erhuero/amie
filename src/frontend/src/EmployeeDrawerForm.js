import {Drawer, Input, Col, Form, Row, Button, Spin} from 'antd';
import {addNewEmployee} from "./client";
import {LoadingOutlined} from "@ant-design/icons";
import {useState} from "react";
import {errorNotification, successNotification} from "./Notification";

const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />;

function EmployeeDrawerForm({showDrawer, setShowDrawer, fetchEmployees}) {
    const onCLose = () => setShowDrawer(false);
    const[submitting, setSubmitting] = useState(false);

    const onFinish = employee => {
        setSubmitting(true)
        console.log(JSON.stringify(employee, null, 2));
        addNewEmployee(employee)
            .then(()=> {
                console.log("Employé est ajouté")
                onCLose();
                successNotification(
                    "Employé ajouté avec succès",
                    `${employee.firstName} ${employee.lastName} a ete ajouté`
                    )
                fetchEmployees();
            }).catch(err => {
                console.log(err);
                err.response.json().then(res => {
                    console.log(res);
                    errorNotification(
                        "Dysfonctionnement",
                        `${res.message} [${res.status}] [${res.error}]`,
                        "bottomLeft"
                )
            });
        }).finally(() => {
            setSubmitting(false);
        })
    };

    const onFinishFailed = errorInfo => {
        alert(JSON.stringify(errorInfo, null, 2));
    };

    return <Drawer
        title="Enregistrer un nouvel employé"
        width={720}
        onClose={onCLose}
        open={showDrawer}
        bodyStyle={{paddingBottom: 80}}
        footer={
            <div
                style={{
                    textAlign: 'right',
                }}
            >
                <Button onClick={onCLose} style={{marginRight: 8}}>
                    Fermer
                </Button>
            </div>
        }
    >
        <Form layout="vertical"
              onFinishFailed={onFinishFailed}
              onFinish={onFinish}
              hideRequiredMark>
            <Row gutter={16}>
                <Col span={12}>
                    <Form.Item
                        name="firstName"
                        label="Prenom"
                        rules={[{required: true, message: 'Prénom du employé'}]}
                    >
                        <Input placeholder="Enregistrer le prénom du employé"/>
                    </Form.Item>
                </Col>
                <Col span={12}>
                    <Form.Item
                        name="lastName"
                        label="Nom"
                        rules={[{required: true, message: 'Nom du employé'}]}
                    >
                        <Input placeholder="Enregistrer le nom du employé"/>
                    </Form.Item>
                </Col>
            </Row>
            <Row>
                <Col span={12}>
                    <Form.Item >
                        <Button type="primary" htmlType="submit">
                            Enregistrer
                        </Button>
                    </Form.Item>
                </Col>
            </Row>
            <Row>
                {submitting && <Spin indicator = {antIcon} />}
            </Row>
        </Form>
    </Drawer>
}

export default EmployeeDrawerForm;