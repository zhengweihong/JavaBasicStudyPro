package P16_Command;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 命令模式，测试
 */
public class Main {
    public static void main(String[] args) {
        Content content = new Content("balabalahong");

        Command insertCommand = new InsertCommand(content);
        insertCommand.exec();
        insertCommand.undo();

        Command copyCommand = new CopyCommand(content);
        copyCommand.exec();
        copyCommand.undo();

        Command deleteCommand = new DeleteCommand(content);
        deleteCommand.exec();
        deleteCommand.undo();

        System.out.println(content.getMsg());
    }
}
