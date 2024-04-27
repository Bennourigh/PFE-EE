package org.mgb.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.List;

//@Entity
//@Table(name="wishlist")
//@Getter @Setter@NoArgsConstructor @AllArgsConstructor @Builder @ToString
//public class WishList {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String username;
//    private Date createdAt;
//
//    @OneToMany(mappedBy = "wishlist")
//    @ToString.Exclude
//    private List<ProductItem> productItems;
//}
//@Override
//public ResponseEntity<ModelResponse> addclassesTomodule(UUID moduleId, List<UUID> classesIds) {
//    try {
//        // Fetch the module by ID
//        module module = moduleRepository.findById(moduleId)
//                .orElseThrow(() -> new EntityNotFoundException("Module not found with id: " + moduleId));
//
//        // Fetch the existing classes related to the module
//        List<classe> existingClasses = module.getClasses();
//
//        // Fetch the classes by their IDs
//        List<classe> classesToAdd = classeRepository.findAllById(classesIds);
//
//        // Filter out redundant and already related classes
//        List<classe> filteredClasses = classesToAdd.stream()
//                .filter(classe -> !existingClasses.contains(classe))
//                .collect(Collectors.toList());
//
//        // Remove classes that are no longer in the provided list
//        List<classe> classeToRemove = existingClasses.stream()
//                .filter(classe -> !classesToAdd.contains(classe))
//                .collect(Collectors.toList());
//
//        // Add the filtered classes to the module
//        module.getClasses().addAll(filteredClasses);
//
//        // Remove classes that are no longer in the provided list
//        module.getClasses().removeAll(classeToRemove);
//
//        // Save the updated module
//        moduleRepository.save(module);
//
//        ModelResponse response = new ModelResponse("Classes added to module successfully", new ArrayList<>(), HttpStatus.OK);
//        return ResponseEntity.ok(response);
//    } catch (Exception ex) {
//        ex.printStackTrace();
//        ModelResponse errorResponse = new ModelResponse("Error adding classes to module", new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}