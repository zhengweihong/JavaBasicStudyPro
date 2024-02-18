package P16_Command;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 复制命令
 */
public class CopyCommand extends Command {
    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    public void exec() {
        c.setMsg(c.getMsg() + c.getMsg());
    }

    @Override
    public void undo() {
        c.setMsg(c.getMsg().substring(0, c.getMsg().length() / 2));
    }
}
