package fr.ird.common.list.comprehesion;

/**
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @param <In>
 * @param <Out>
 * @since 1.1
 * @date 27 mai 2014
 */
public interface Func<In, Out> {

    public Out apply(In in);
}
