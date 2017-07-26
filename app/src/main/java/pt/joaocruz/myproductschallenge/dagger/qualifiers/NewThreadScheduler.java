package pt.joaocruz.myproductschallenge.dagger.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by joaocruz04 on 26/07/2017.
 */


@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface NewThreadScheduler {
}