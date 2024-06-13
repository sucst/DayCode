package cn.atsuc.designmodel.memorandum;

import cn.atsuc.Fanctory.memorandum.Admin;
import cn.atsuc.Fanctory.memorandum.ConfigFile;
import cn.atsuc.Fanctory.memorandum.ConfigOriginator;
import com.alibaba.fastjson2.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author csup
 * @creatTime 2024/5/21 12:20
 * @description
 */
public class memorandum {
    private Logger logger = LoggerFactory.getLogger(memorandum.class);
    @Test
    public void test() {
        Admin admin = new Admin();
        ConfigOriginator configOriginator = new ConfigOriginator();
        configOriginator.setConfigFile(new ConfigFile("1000001", "配置内容A=哈哈", new Date(), "tt"));
        admin.append(configOriginator.saveMemento()); // 保存配置
        configOriginator.setConfigFile(new ConfigFile("1000002", "配置内容A=嘻嘻", new Date(), "tt"));
        admin.append(configOriginator.saveMemento()); // 保存配置
        configOriginator.setConfigFile(new ConfigFile("1000003", "配置内容A=么么", new Date(), "tt"));
        admin.append(configOriginator.saveMemento()); // 保存配置
        configOriginator.setConfigFile(new ConfigFile("1000004", "配置内容A=嘿嘿", new Date(), "tt"));
        admin.append(configOriginator.saveMemento()); // 保存配置

        // 历史配置(回滚)
        configOriginator.getMemento(admin.undo());
        logger.info("历史配置(回滚)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置(回滚)
        configOriginator.getMemento(admin.undo());
        logger.info("历史配置(回滚)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置(前进)
        configOriginator.getMemento(admin.redo());
        logger.info("历史配置(前进)redo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置(获取)
        configOriginator.getMemento(admin.get("1000002"));
        logger.info("历史配置(获取)get：{}", JSON.toJSONString(configOriginator.getConfigFile()));
    }
}
