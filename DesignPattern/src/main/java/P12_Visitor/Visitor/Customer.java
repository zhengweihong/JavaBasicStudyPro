package P12_Visitor.Visitor;

import P12_Visitor.ComputerPart.*;

/**
 * @author : ZWH
 * @date : 2024/02/07
 * @Description : 顾客，访问者接口
 */
public interface Customer {
    void visitCPU(CPU cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);
}
