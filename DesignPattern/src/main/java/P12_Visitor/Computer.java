package P12_Visitor;

import P12_Visitor.ComputerPart.*;
import P12_Visitor.Visitor.Customer;

/**
 * @author : ZWH
 * @date : 2024/02/07
 * @Description : 电脑，组合类
 */
public class Computer {
    private ComputerPart cpu = new CPU();
    private ComputerPart memory = new Memory();
    private ComputerPart board = new Board();

    public void access(Customer customer) {
        this.cpu.access(customer);
        this.memory.access(customer);
        this.board.access(customer);
    }
}
