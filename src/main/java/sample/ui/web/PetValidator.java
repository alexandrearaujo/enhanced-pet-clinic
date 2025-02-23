/*
 * Copyright 2002-2014 the original author or authors.
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
package sample.ui.web;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import sample.ui.model.Pet;

/**
 * <code>Validator</code> for <code>Pet</code> forms.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Arnaldo Piccinelli
 */
public class PetValidator {

    public void validate(Pet pet, Errors errors) {
        String name = pet.getName();
        if (!StringUtils.hasLength(name)) {
            errors.rejectValue("name", "required", new Object[] {"Name"}, "required");
        } else if (pet.isNew() && pet.getOwner().getPet(name, true) != null) {
            errors.rejectValue("name", "duplicate", new Object[] {name}, "already exists");
        }
    }

}
