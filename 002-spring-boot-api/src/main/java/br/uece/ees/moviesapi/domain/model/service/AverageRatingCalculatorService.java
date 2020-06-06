package br.uece.ees.moviesapi.domain.model.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import br.uece.ees.moviesapi.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import br.uece.ees.moviesapi.domain.model.repository.ReviewRepositoryInterface;

@Service
public class AverageRatingCalculatorService {

    private final ReviewRepositoryInterface reviews;

    @Autowired
    public AverageRatingCalculatorService(ReviewRepositoryInterface repository)
    {
        reviews = repository;
    }

    public float averageRatingFor(Movie movie)
    {
        var all = reviews.all(movie);
        int summation = 0;
        if (all.isEmpty())
            return (short) summation;

        int numberOfItems = all.size();
        for (var review : all)
            summation += Character.getNumericValue(review.getRating());

        float averageRating = (float) summation / numberOfItems;
        BigDecimal precisionController = new BigDecimal(averageRating).setScale(1, RoundingMode.HALF_UP);
        return precisionController.floatValue();
    }

}
