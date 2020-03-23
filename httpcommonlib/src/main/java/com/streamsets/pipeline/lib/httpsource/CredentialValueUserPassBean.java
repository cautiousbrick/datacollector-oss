/*
 * Copyright 2019 StreamSets Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.pipeline.lib.httpsource;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.StageException;
import com.streamsets.pipeline.api.credential.CredentialValue;

public class CredentialValueUserPassBean implements CredentialValue {

  @ConfigDef(
      required = true,
      label = "Username",
      type = ConfigDef.Type.STRING,
      defaultValue = "",
      displayPosition = 10
  )
  public String username;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.CREDENTIAL,
      defaultValue = "",
      label = "Password",
      displayPosition = 10
  )
  public CredentialValue password;

  public CredentialValueUserPassBean(String username, String password){
    this.password = () -> password;
    this.username = username;
  }

  public CredentialValueUserPassBean(){
    this.password = () -> "";
    this.username = "";
  }

  @Override
  public String get() throws StageException {
    return password.get();
  }

  public String getUsername() throws StageException {
    return username;
  }
}