package secondVersion;

import javafx.beans.property.BooleanPropertyBase;

import java.io.Serializable;

public class SimpleBooleanProperty1 extends BooleanPropertyBase implements Serializable {

    private static final Object DEFAULT_BEAN = null;
    private static final String DEFAULT_NAME = "";

    private final Object bean;
    private final String name;

    /**
     * The constructor of {@code BooleanProperty}
     */
    public SimpleBooleanProperty1() {
        this(DEFAULT_BEAN, DEFAULT_NAME);
    }

    /**
     * The constructor of {@code BooleanProperty}
     *
     * @param initialValue the initial value of the wrapped value
     */
    public SimpleBooleanProperty1(boolean initialValue) {
        this(DEFAULT_BEAN, DEFAULT_NAME, initialValue);
    }

    /**
     * The constructor of {@code BooleanProperty}
     *
     * @param bean the bean of this {@code BooleanProperty}
     * @param name the name of this {@code BooleanProperty}
     */
    public SimpleBooleanProperty1(Object bean, String name) {
        this.bean = bean;
        this.name = (name == null) ? DEFAULT_NAME : name;
    }

    /**
     * The constructor of {@code BooleanProperty}
     *
     * @param bean         the bean of this {@code BooleanProperty}
     * @param name         the name of this {@code BooleanProperty}
     * @param initialValue the initial value of the wrapped value
     */
    public SimpleBooleanProperty1(Object bean, String name, boolean initialValue) {
        super(initialValue);
        this.bean = bean;
        this.name = (name == null) ? DEFAULT_NAME : name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getBean() {
        return bean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

}
