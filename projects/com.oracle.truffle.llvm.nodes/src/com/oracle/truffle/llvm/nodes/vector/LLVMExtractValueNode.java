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
package com.oracle.truffle.llvm.nodes.vector;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.llvm.nodes.base.LLVMAddressNode;
import com.oracle.truffle.llvm.nodes.base.floating.LLVM80BitFloatNode;
import com.oracle.truffle.llvm.nodes.base.floating.LLVMDoubleNode;
import com.oracle.truffle.llvm.nodes.base.floating.LLVMFloatNode;
import com.oracle.truffle.llvm.nodes.base.integers.LLVMI16Node;
import com.oracle.truffle.llvm.nodes.base.integers.LLVMI1Node;
import com.oracle.truffle.llvm.nodes.base.integers.LLVMI32Node;
import com.oracle.truffle.llvm.nodes.base.integers.LLVMI64Node;
import com.oracle.truffle.llvm.nodes.base.integers.LLVMI8Node;
import com.oracle.truffle.llvm.types.LLVMAddress;
import com.oracle.truffle.llvm.types.floating.LLVM80BitFloat;
import com.oracle.truffle.llvm.types.memory.LLVMMemory;

public class LLVMExtractValueNode {

    @NodeChildren({@NodeChild(type = LLVMAddressNode.class)})
    public abstract static class LLVMExtractI1ValueNode extends LLVMI1Node {

        @Specialization
        public boolean executeI1(LLVMAddress address) {
            return LLVMMemory.getI1(address);
        }

    }

    @NodeChildren({@NodeChild(type = LLVMAddressNode.class)})
    public abstract static class LLVMExtractI8ValueNode extends LLVMI8Node {

        @Specialization
        public byte executeI8(LLVMAddress address) {
            return LLVMMemory.getI8(address);
        }

    }

    @NodeChildren({@NodeChild(type = LLVMAddressNode.class)})
    public abstract static class LLVMExtractI16ValueNode extends LLVMI16Node {

        @Specialization
        public short executeI16(LLVMAddress address) {
            return LLVMMemory.getI16(address);
        }

    }

    @NodeChildren({@NodeChild(type = LLVMAddressNode.class)})
    public abstract static class LLVMExtractI32ValueNode extends LLVMI32Node {

        @Specialization
        public int executeI32(LLVMAddress address) {
            return LLVMMemory.getI32(address);
        }

    }

    @NodeChildren({@NodeChild(type = LLVMAddressNode.class)})
    public abstract static class LLVMExtractI64ValueNode extends LLVMI64Node {

        @Specialization
        public long executeI64(LLVMAddress address) {
            return LLVMMemory.getI64(address);
        }

    }

    @NodeChildren({@NodeChild(type = LLVMAddressNode.class)})
    public abstract static class LLVMExtractFloatValueNode extends LLVMFloatNode {

        @Specialization
        public float executeFloat(LLVMAddress address) {
            return LLVMMemory.getFloat(address);
        }

    }

    @NodeChildren({@NodeChild(type = LLVMAddressNode.class)})
    public abstract static class LLVMExtractDoubleValueNode extends LLVMDoubleNode {

        @Specialization
        public double executeDouble(LLVMAddress address) {
            return LLVMMemory.getDouble(address);
        }

    }

    @NodeChildren({@NodeChild(type = LLVMAddressNode.class)})
    public abstract static class LLVMExtract80BitFloatValueNode extends LLVM80BitFloatNode {

        @Specialization
        public LLVM80BitFloat execute80BitFloat(LLVMAddress address) {
            return LLVMMemory.get80BitFloat(address);
        }

    }

    @NodeChildren({@NodeChild(type = LLVMAddressNode.class)})
    public abstract static class LLVMExtractAddressValueNode extends LLVMAddressNode {

        @Specialization
        public LLVMAddress executePointee(LLVMAddress address) {
            LLVMAddress structElement = LLVMMemory.getAddress(address);
            return structElement;
        }

    }

}
