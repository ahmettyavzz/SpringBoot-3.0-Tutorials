package com.yavuzahmet.dto;

/**
 * Record use
 */

public record PostDto(  Long id,
         String userId,
         String title,
         String body) {
}