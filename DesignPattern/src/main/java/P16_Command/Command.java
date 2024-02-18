package P16_Command;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 命令抽象类
 */
public abstract class Command {
    Content c;

    // 也可命名为doit、run
    public abstract void exec();
    public abstract void undo();
}
