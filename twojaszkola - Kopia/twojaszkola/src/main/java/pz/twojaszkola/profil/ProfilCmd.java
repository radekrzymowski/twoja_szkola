/*
 * Copyright 2016 michael-simons.eu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pz.twojaszkola.profil;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;

/**
 *
 * @author radon
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfilCmd {
    
    @NotNull
    private ProfilEntity profil_nazwa;

    public ProfilEntity getProfil_nazwa() {
        return profil_nazwa;
    }

    public void setProfil_nazwa(ProfilEntity profil_nazwa) {
        this.profil_nazwa = profil_nazwa;
    }
    
    
}
