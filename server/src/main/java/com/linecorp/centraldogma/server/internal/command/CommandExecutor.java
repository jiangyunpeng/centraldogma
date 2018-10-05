/*
 * Copyright 2017 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.centraldogma.server.internal.command;

import java.util.concurrent.CompletableFuture;

public interface CommandExecutor {

    int replicaId();

    boolean isStarted();

    CompletableFuture<Void> start();

    CompletableFuture<Void> stop();

    boolean isWritable();

    void setWritable(boolean writable);

    <T> CompletableFuture<T> execute(Command<T> command);

    <T> CompletableFuture<T> execute(int replicaId, Command<T> command);
}
