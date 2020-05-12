package com.gitee.carloshuang.config

import com.gitee.carloshuang.execute.MyPreExecute
import net.hasor.core.ApiBinder
import net.hasor.core.DimModule
import net.hasor.dataway.spi.PreExecuteChainSpi
import net.hasor.db.JdbcModule
import net.hasor.db.Level
import net.hasor.spring.SpringModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.sql.DataSource


/**
 * 初始化数据源.
 *
 * @author: Carlos Huang
 * @Date: 5-11
 */
@DimModule
@Component
class DatawayModule: SpringModule {

    @Autowired
    lateinit var dataSource: DataSource

    override fun loadModule(apiBinder: ApiBinder?) {
        apiBinder!!.installModule(JdbcModule(Level.Full, dataSource))
        // 注册拦截器
        apiBinder.bindSpiListener(PreExecuteChainSpi::class.java, MyPreExecute())
    }

}