@Override
public RatingEntity addRating(Long propertyId) {

    PropertyEntity property = propertyRepo.findById(propertyId)
            .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

    FacilityScoreEntity score = scoreRepo.findByProperty(property)
            .orElseThrow(() -> new ResourceNotFoundException("Facility score not found"));

    double average = (
            score.getSchoolProximity() +
            score.getHospitalProximity() +
            score.getTransportAccess() +
            score.getSafetyScore()
    ) / 4.0;

    double finalRating = average * 10;

    String category;
    if (finalRating < 40) {
        category = "POOR";
    } else if (finalRating < 60) {
        category = "AVERAGE";
    } else if (finalRating < 80) {
        category = "GOOD";
    } else {
        category = "EXCELLENT";
    }

    RatingEntity rating = new RatingEntity();
    rating.setFinalRating(finalRating);
    rating.setRatingCategory(category);
    rating.setProperty(property);

    return ratingRepo.save(rating);
}
