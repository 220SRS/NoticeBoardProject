package com.toyProject.NBPOrigin.mapper;


import com.toyProject.NBPOrigin.dto.PostDto;
import com.toyProject.NBPOrigin.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    Post PostDtoToPost (PostDto postDto);
    Post PostToPostDto (Post post);
}
