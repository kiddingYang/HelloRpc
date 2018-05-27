package com.tg.rpc.example.single.zookeeper;

import com.tg.rpc.core.bootstrap.Client;
import com.tg.rpc.core.config.ClientProperty;
import com.tg.rpc.core.proxy.ClientProxy;
import com.tg.rpc.core.proxy.DefaultClientInterceptor;
import com.tg.rpc.core.proxy.JdkClientProxy;
import com.tg.rpc.core.servicecenter.ServiceDiscovery;
import com.tg.rpc.example.service.EchoService;
import com.tg.rpc.example.service.TestService;
import com.tg.rpc.zookeeper.ZookeeperCompentFactory;

import java.util.Arrays;

/**
 * Created by twogoods on 17/2/17.
 */
public class ClientBootstrap {
    public static void main(String[] args) throws Exception {
        ClientProperty clientA = new ClientProperty();
        clientA.serviceName("testService")
        .setInterfaces(Arrays.asList("com.tg.rpc.example.service.EchoService","com.tg.rpc.example.service.EchoService"));
        ServiceDiscovery serviceDiscovery = ZookeeperCompentFactory.getDiscovery("111.231.62.191",2181,"/tgrpc/services");
        Client client = new Client.Builder()
                .serviceDiscovery(serviceDiscovery)
                .connectionMinIdle(1)
                .maxCapacity(3)
                .client(clientA)
                .build();
        DefaultClientInterceptor interceptor = new DefaultClientInterceptor(client);
        ClientProxy clientProxy = new JdkClientProxy(interceptor);

        EchoService echoService = clientProxy.getProxy(EchoService.class);
        System.out.println(echoService.echo("twogoods"));

        TestService testService = clientProxy.getProxy(TestService.class);
        System.out.println(testService.add(2, 5));

    }
}
