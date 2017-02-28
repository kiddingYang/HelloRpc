package com.tg.rpc.core.servicecenter;

import java.net.URL;

/**
 * Description:
 *
 * @author twogoods
 * @version 0.1
 * @since 2017-02-28
 */
public interface ServiceRegistry {

    void register(Service service);

    void unregister(Service service);
}
