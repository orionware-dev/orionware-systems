package core.runnables.consumers;

@FunctionalInterface
public interface Consumer3<T1, T2, T3> extends OrionConsumer
{
    public void run(T1 t1, T2 t2, T3 t3);
}