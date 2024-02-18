package P16_Command;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 删除命令
 */
public class DeleteCommand extends Command {
    String deleted;

    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void exec() {
        deleted = c.getMsg().substring(0, 2);
        c.setMsg(c.getMsg().substring(2));
    }

    @Override
    public void undo() {
        c.setMsg(deleted + c.getMsg());
    }
}
