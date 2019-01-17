package structural.composite;

import java.util.*;
import java.util.function.Consumer;

interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
    {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
}


class MyList extends ArrayList<ValueContainer>
{
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
        int result = 0;
        for (ValueContainer values: this) {
            for (int value : values) {
                result += value;
            }
        }
        return result;
    }
}

class Demo24 {
    public static void main(String[] args) {
        SingleValue single1 = new SingleValue(2);
        SingleValue single2 = new SingleValue(2);
        ManyValues manyValues = new ManyValues();
        manyValues.add(5);
        manyValues.add(4);
        manyValues.add(1);
        System.out.println(new MyList(List.of(single1, single2, manyValues)).sum());

    }
}