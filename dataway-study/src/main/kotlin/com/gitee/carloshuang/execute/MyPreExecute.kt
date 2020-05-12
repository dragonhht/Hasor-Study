package com.gitee.carloshuang.execute

import net.hasor.dataway.spi.ApiInfo
import net.hasor.dataway.spi.PreExecuteChainSpi
import net.hasor.dataway.spi.StatusMessageException
import net.hasor.utils.StringUtils
import net.hasor.utils.future.BasicFuture
import net.hasor.dataql.fx.web.WebUdfSource as webData

/**
 * 拦截器
 * (用户调用接口时检查header内是否存在token).
 *
 * @author: Carlos Huang
 * @Date: 5-12
 */
class MyPreExecute: PreExecuteChainSpi {

    override fun preExecute(apiInfo: ApiInfo?, future: BasicFuture<Any>?) {
        // 获取header内参数
        val token = webData.getHeader("token")
        if (StringUtils.isNotBlank(token)) {
            println("token is $token")
        } else {
            future?.failed(StatusMessageException(401, "not login"))
            //throw StatusMessageException(401, "not login")
        }
    }

}