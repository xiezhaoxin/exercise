package cn.xiezhaoxin.javaee.jmx;

import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

/**
 * Created by fish on 6/21/16.
 */
public class HelloServer {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1234);//必须要这句，参数为端口号
        Hello hello = new Hello();
        ObjectName helloName = new ObjectName("xie:name=hello");
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        // provide a valid username and password (e.g., via program arguments)
        String user = "monitorRole";
        String pw = "password";

        // place the username and password in a string array of credentials that can be used when making the connection to the remote JMX agent
        String[] credentials = new String[] {user, pw};
        // the string array of credentials is placed in a map keyed against the well-defined credentials identifier string
        Map<String, String[]> props = new HashMap<String, String[]>();
        props.put("jmx.remote.credentials", credentials);
        // supply the map of credentials to the connect call
        JMXServiceURL address = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1234/jmxrmi");
        JMXConnectorServer cserver = JMXConnectorServerFactory.newJMXConnectorServer(address, props, server);
        cserver.start();
        server.registerMBean(hello, helloName);
    }
}
