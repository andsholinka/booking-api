package com.andrey.bookingapi.studio;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andrey.bookingapi.studio.models.Studio;
import com.andrey.bookingapi.studio.models.dto.StudioRequest;
import com.andrey.bookingapi.studio.models.dto.StudioResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/studios")
@Tag(name = "Studio", description = "Studio operations")
public class StudioController {
    private final StudioService studioService;

    @GetMapping("")
    public ResponseEntity<List<StudioResponse>> getAllStudio(@RequestParam("name") Optional<String> optionalTitle) {
        List<Studio> studios = this.studioService.getAllStudio();
        List<StudioResponse> studioResponses = studios.stream().map(s -> s.convertStudioResponse()).toList();
        return ResponseEntity.status(HttpStatus.OK).body(studioResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudioResponse> getOneStudio(@PathVariable("id") Long id) {
        Studio studio = this.studioService.findOneById(id);
        StudioResponse studioResponse = studio.convertStudioResponse();
        return ResponseEntity.status(HttpStatus.OK).body(studioResponse);
    }

    @PostMapping("")
    public ResponseEntity<StudioResponse> createOneStudio(@RequestBody StudioRequest studioRequest) {
        Studio newStudio = studioRequest.convertToEntity();
        Studio saveStudio = this.studioService.createOne(newStudio);
        StudioResponse studioResponse = saveStudio.convertStudioResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(studioResponse);
    }
}
