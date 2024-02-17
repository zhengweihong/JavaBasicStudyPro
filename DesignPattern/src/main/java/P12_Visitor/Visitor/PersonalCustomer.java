package P12_Visitor.Visitor;

import P12_Visitor.ComputerPart.*;

/**
 * @author : ZWH
 * @date : 2024/02/07
 * @Description : 个人客户，访问者实现
 */
public class PersonalCustomer implements Customer {
    public double totalPrice = 0.0;

    @Override
    public void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice();
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice();
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice();
    }
}
