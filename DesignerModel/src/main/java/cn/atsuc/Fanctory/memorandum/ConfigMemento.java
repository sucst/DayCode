package cn.atsuc.Fanctory.memorandum;

/**
 * @author csup
 * @creatTime 2024/5/21 12:19
 * @description
 */
public class ConfigMemento {

    private ConfigFile configFile;

    public ConfigMemento(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }

}
