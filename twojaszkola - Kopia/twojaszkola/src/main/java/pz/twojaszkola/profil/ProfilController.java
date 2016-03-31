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

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pz.twojaszkola.support.ResourceNotFoundException;

/**
 *
 * @author radon
 */
@RestController
@RequestMapping("/api")
public class ProfilController {
 
        private final ProfilRepository profilRepository;

        @Autowired
        public ProfilController(final ProfilRepository profilRepository) {
            this.profilRepository = profilRepository;
        }
        
        @RequestMapping(value = "/profil", method = GET)
        public List<ProfilEntity> getprofil(final @RequestParam(required = false, defaultValue = "false") boolean all) {
            List<ProfilEntity> rv;
            rv = profilRepository.findAll(new Sort(Sort.Direction.ASC, "profil_nazwa"));
            return rv;
        }
        
        @RequestMapping(value = "/profil", method = POST) 
        @PreAuthorize("isAuthenticated()")
        public ProfilEntity createProfil(final @RequestBody @Valid ProfilCmd newProfil, final BindingResult bindingResult) {
            if(bindingResult.hasErrors()) {
                throw new IllegalArgumentException("Invalid arguments.");
            }
	
            final ProfilEntity profil = new ProfilEntity(newProfil.getProfil_nazwa());
            return this.profilRepository.save(profil);	
        }
        
        @RequestMapping(value = "/profil{id:\\d+}", method = PUT)
        @PreAuthorize("isAuthenticated()")
        @Transactional
        public ProfilEntity updateprofil(final @PathVariable Integer id, final @RequestBody @Valid ProfilCmd updatedprofil, final BindingResult bindingResult) {
            if(bindingResult.hasErrors()) {
                throw new IllegalArgumentException("Invalid arguments.");
            }
	
            final ProfilEntity profil = profilRepository.findOne(id);
		
            if(profil == null) {
                throw new ResourceNotFoundException();
            } 
            
            return profil;
        }
}
