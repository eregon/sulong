/*
 * Copyright (c) 2016, Oracle and/or its affiliates.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided
 * with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.oracle.truffle.llvm.nodes.op.arith.vector;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.llvm.nodes.base.LLVMAddressNode;
import com.oracle.truffle.llvm.nodes.base.vector.LLVMI16VectorNode;
import com.oracle.truffle.llvm.types.LLVMAddress;
import com.oracle.truffle.llvm.types.vector.LLVMI16Vector;

@NodeChildren({@NodeChild(value = "addressNode", type = LLVMAddressNode.class), @NodeChild("leftNode"), @NodeChild("rightNode")})
public abstract class LLVMI16VectorArithmeticNode extends LLVMI16VectorNode {

    public abstract static class LLVMI16VectorAddNode extends LLVMI16VectorArithmeticNode {
        @Specialization
        protected LLVMI16Vector executeI16Vector(LLVMAddress target, LLVMI16Vector left, LLVMI16Vector right) {
            return left.add(target, right);
        }
    }

    public abstract static class LLVMI16VectorMulNode extends LLVMI16VectorArithmeticNode {

        @Specialization
        public LLVMI16Vector executeI16Vector(LLVMAddress target, LLVMI16Vector left, LLVMI16Vector right) {
            return left.mul(target, right);
        }

    }

    public abstract static class LLVMI16VectorSubNode extends LLVMI16VectorArithmeticNode {

        @Specialization
        protected LLVMI16Vector executeI16Vector(LLVMAddress target, LLVMI16Vector left, LLVMI16Vector right) {
            return left.sub(target, right);
        }
    }

    public abstract static class LLVMI16VectorDivNode extends LLVMI16VectorArithmeticNode {

        @Specialization
        protected LLVMI16Vector executeI16Vector(LLVMAddress target, LLVMI16Vector left, LLVMI16Vector right) {
            return left.div(target, right);
        }
    }

    public abstract static class LLVMI16VectorUDivNode extends LLVMI16VectorArithmeticNode {

        @Specialization
        protected LLVMI16Vector executeI16Vector(LLVMAddress target, LLVMI16Vector left, LLVMI16Vector right) {
            return left.udiv(target, right);
        }
    }

    public abstract static class LLVMI16VectorRemNode extends LLVMI16VectorArithmeticNode {

        @Specialization
        protected LLVMI16Vector executeI16Vector(LLVMAddress target, LLVMI16Vector left, LLVMI16Vector right) {
            return left.rem(target, right);
        }
    }

    public abstract static class LLVMI16VectorURemNode extends LLVMI16VectorArithmeticNode {

        @Specialization
        protected LLVMI16Vector executeI16Vector(LLVMAddress target, LLVMI16Vector left, LLVMI16Vector right) {
            return left.urem(target, right);
        }
    }
}
