package P16_Command;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 插入命令
 */
public class InsertCommand extends Command {
    String insertStr = "insert content";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void exec() {
        c.setMsg(c.getMsg() + insertStr);
    }

    @Override
    public void undo() {
        c.setMsg(c.getMsg().substring(0, c.getMsg().length() - insertStr.length()));
    }
}
