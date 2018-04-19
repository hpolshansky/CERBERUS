package cerberusMonitor;

import java.io.IOException;
import java.util.logging.*;

public class CERBERUSLogger {
    private static Logger logger;

    public CERBERUSLogger() throws IOException{
        //instance the logger
        logger = Logger.getLogger(CERBERUSLogger.class.getName());
        //instance the filehandler
        Handler fileHandler = new FileHandler("log.txt", true);
        //instance formatter, set formatting, and handler
        SimpleFormatter plainText = new SimpleFormatter();
        fileHandler.setFormatter(plainText);
        logger.addHandler(fileHandler);
    }

    private static Logger getLogger(){
        if(logger == null){
            try {
                new CERBERUSLogger();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logger;
    }

    public static void log(Level level, String msg){
        getLogger().log(level, msg);
    }
}
