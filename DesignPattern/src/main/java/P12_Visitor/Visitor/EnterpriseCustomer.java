package P12_Visitor.Visitor;

import P12_Visitor.ComputerPart.*;

/**
 * @author : ZWH
 * @date : 2024/02/07
 * @Description : 企业客户，访问者实现
 */
public class EnterpriseCustomer implements Customer {
    public double totalPrice = 0.0;

    @Override
    public void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.8;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.8;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.8;
    }
}
