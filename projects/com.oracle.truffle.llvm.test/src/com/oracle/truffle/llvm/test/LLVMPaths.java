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
package com.oracle.truffle.llvm.test;

import java.io.File;

import com.oracle.truffle.llvm.runtime.LLVMOptions;

public final class LLVMPaths {

    private LLVMPaths() {
    }

    static final String IGNORE_FOLDER_NAME = "ignore";
    static final String TEMPORARY_BITFILE_FOLDER = "compiled-llvm-tests";
    static final File TEMP_DIRECTORY = new File(System.getProperty("java.io.tmpdir"), TEMPORARY_BITFILE_FOLDER);

    static final String NO_OPTIMIZATIONS_FOLDER_NAME = "noopt";

    static final File PROJECT_ROOT = new File(LLVMOptions.getProjectRoot() + File.separator + LLVMPaths.class.getPackage().getName());

    static final File LOCAL_TESTS = new File(PROJECT_ROOT, "tests/");
    static final File EXTERNAL_TEST_SUITES = new File(PROJECT_ROOT, "suites/");
    static final File EXTERNAL_TEST_SUITES_CONFIG = new File(PROJECT_ROOT, "suites-configs/");

    // LLVM test suite
    static final File LLVM_TEST_SUITE = new File(EXTERNAL_TEST_SUITES, "llvm/");
    static final File LLVM_TEST_SUITE_CONFIG = new File(EXTERNAL_TEST_SUITES_CONFIG, "llvm/");

    // GCC test suite
    public static final File GCC_TEST_SUITE = new File(EXTERNAL_TEST_SUITES, "gcc/gcc-5.2.0/gcc/testsuite");
    public static final File GCC_TEST_SUITE_CONFIG = new File(EXTERNAL_TEST_SUITES_CONFIG, "gcc/");

    // NWCC test suite
    public static final File NWCC_TEST_SUITE = new File(EXTERNAL_TEST_SUITES, "nwcc/");
    public static final File NWCC_TEST_SUITE_CONFIG = new File(EXTERNAL_TEST_SUITES_CONFIG, "nwcc/");

    public static final File FLUSH_BITCODE_FILE = new File(PROJECT_ROOT, "flush.temp.ll");
    public static final File FLUSH_C_FILE = new File(PROJECT_ROOT, "flush.c");

    public static final File BENCHMARK_GAME_SUITE = new File(EXTERNAL_TEST_SUITES, "benchmarkgame/");

    static {
        TEMP_DIRECTORY.mkdir();
    }

}
