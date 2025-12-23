@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/generate/{propertyId}")
    public RatingEntity generateRating(@PathVariable Long propertyId) {
        return ratingService.addRating(propertyId);
    }

    @GetMapping("/{propertyId}")
    public RatingEntity getRating(@PathVariable Long propertyId) {
        return ratingService.getRating(propertyId);
    }
}
