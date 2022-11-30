import { useState, useEffect } from 'react';
import {deleteEmployee, getAllEmployee} from "./client";
import {
  Layout,
  Menu,
  Breadcrumb,
  Table,
  Empty,
  Button,
  Tag,
  Badge,
  Popconfirm,
  Radio,
  Image,
  Divider
} from 'antd';
import React from 'react';
import { Spin } from 'antd';
import {
  DesktopOutlined,
  PieChartOutlined,
  FileOutlined,
  TeamOutlined,
  UserOutlined,
  LoadingOutlined,
  PlusOutlined
} from '@ant-design/icons';

import EmployeeDrawerForm from "./EmployeeDrawerForm";
import './App.css';
import {errorNotification, successNotification} from "./Notification";

const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu;
/*
const TheAvatar = ({}) => {
  const trim = "";
  if (trim.length === 0) {
    return <Avatar icon={<UserOutlined/>}/>
  }
}
*/
const removeEmployee = (employee, callback) => {
  deleteEmployee(employee).then(() => {
    successNotification("Employé supprimé", `Employé ${employee} à été supprimé`);
    callback();
  }).catch(err => {
  err.response.json().then(res => {
    console.log(res);
    errorNotification(
        "Dysfonctionnement dans la suppression détécté",
        `${res.message} [${res.status}] [${res.error}]`
      )
    });
  })
}

const columns = fetchEmployees => [/*
  {
    title: '',
    dataIndex: 'avatar',
    key: 'avatar',
    render: (text, employee) =>
        <Avatar/>

  },*/
  {
  title: "Identifiant",
  dataIndex:"id",
  key:"id"
},
  {
    title: "Prenom",
    dataIndex:"firstName",
    key:"firstName"
  },
  {
    title: "Nom",
    dataIndex:"lastName",
    key:"lastName"
  },
  {
    title: 'Actions',
    key: 'actions',
    render: (text, employee) =>
        <Radio.Group>
          <Popconfirm
              placement = 'topRight'
              title = { `Etes vous sûr de supprimer ${employee.firstName} ${employee.lastName}`}
              onConfirm = {() => removeEmployee(employee.id, fetchEmployees)}
              okText = 'Oui'
              cancelText = 'Non'>
              <Radio.Button value = "small">Supprimer</Radio.Button>
          </Popconfirm>
          <Radio.Button value = "small">Editer</Radio.Button>
        </Radio.Group>
  }
];

const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />;

function App() {

  const [employees, setEmployees] = useState([]);
  const [collapsed, setCollapsed] = useState(false);
  const [fetching, setFetching] = useState(true);
  const [showDrawer, setShowDrawer] = useState(false);

  const fetchEmployees = () =>
      getAllEmployee()
          .then(res => res.json())
          .then(data => {
            console.log(data);
            setEmployees(data);
            setFetching(false);
          }).catch(err => {
            console.log(err.response)
        err.response.json().then(res => {
          console.log(res);
          errorNotification(
              "Problème d'affichage",
              `${res.message} [statusCode: ${res.status} ${res.error}]]`
          )
        });
      }).finally(() => setFetching(false))

  useEffect(() => {
    console.log("Composant assemblé");
    fetchEmployees();
  }, []);

  const renderEmployees = () => {
    if (fetching) {
      return <Spin indicator={antIcon} />
    }
    if(employees.length<=0){
      return <>
        <Button
          onClick={() => setShowDrawer(!showDrawer)}
          type="primary" shape="round" icon={<PlusOutlined/>} size="small">
            Ajouter un employé
        </Button>

        <EmployeeDrawerForm
            showDrawer = {showDrawer}
            setShowDrawer = {setShowDrawer}
            fetchEmployees = {fetchEmployees}
        />
        <Empty/>
    </>
  }
    return <>
      <EmployeeDrawerForm
          showDrawer={showDrawer}
          setShowDrawer={setShowDrawer}
          fetchEmployees={fetchEmployees}
          />
      <Table
          dataSource={employees}
          columns={columns(fetchEmployees)}
          bordered
          title={() =>
          <>
            <Tag>Nombre d'employés</Tag>
            <Badge count={employees.length} className="site-badge-count-4"/>
            <br/><br/>
              <Button
                  onClick={() => setShowDrawer(!showDrawer)}
                  type="primary" shape="round" icon={<PlusOutlined/>} size="small">
                  Ajouter un employé
              </Button>
          </>
          }
          pagination={{ pageSize: 50 }}
          scroll={{y: 500}}
          rowKey={(employee) => employee.id}
      />
    </>
  }

  return <Layout style={{ minHeight: '100vh' }}>
    <Sider collapsible collapsed={collapsed}
           onCollapse={setCollapsed}>
      <div className="logo" />
      <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
        <Menu.Item key="1" icon={<PieChartOutlined />}>
          Option 1
        </Menu.Item>
        <Menu.Item key="2" icon={<DesktopOutlined />}>
          Option 2
        </Menu.Item>
        <SubMenu key="sub1" icon={<UserOutlined />} title="User">
          <Menu.Item key="3">Tom</Menu.Item>
          <Menu.Item key="4">Bill</Menu.Item>
          <Menu.Item key="5">Alex</Menu.Item>
        </SubMenu>
        <SubMenu key="sub2" icon={<TeamOutlined />} title="Team">
          <Menu.Item key="6">Team 1</Menu.Item>
          <Menu.Item key="8">Team 2</Menu.Item>
        </SubMenu>
        <Menu.Item key="9" icon={<FileOutlined />}>
          Files
        </Menu.Item>
      </Menu>
    </Sider>
    <Layout className="site-layout">
      <Header className="site-layout-background" style={{ padding: 0 }} />
      <Content style={{ margin: '0 16px' }}>
        <Breadcrumb style={{ margin: '16px 0' }}>
          <Breadcrumb.Item>User</Breadcrumb.Item>
          <Breadcrumb.Item>Bill</Breadcrumb.Item>
        </Breadcrumb>
        <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
          {renderEmployees()}
        </div>
      </Content>
      <Footer style={{ textAlign: 'center' }}>
        <Image
            width={150}
            src="https://user-images.githubusercontent.com/23487296/204789550-79843cc8-1847-4cfe-91d0-bfbc75e063ab.png"
        />
        <Divider>
          <a
              rel="noopener noreferrer"
              target="_blank"
              href="https://www.linkedin.com/in/constantin-chtanko-1b2608194/">
              Mon profil
          </a>
        </Divider>
      </Footer>
    </Layout>
  </Layout>
}

export default App;
