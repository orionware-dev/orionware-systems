package computation.annotation.parallelism;

import com.amd.aparapi.Kernel;
import com.amd.aparapi.Range;

public class GPUParallelismAdditionExample
{
    public static void main(String[] args) throws Exception
    {
        final int size = 536870912;
        final float[] a = new float[size];
        final float[] b = new float[size];

        for(int i = 0; i < size; i++)
        {
            a[i] = (float)(Math.random() * 100);
            b[i] = (float)(Math.random() * 100);
        }

        final float[] sum = new float[size];

        Kernel kernel = new Kernel()
        {
            @Override
            public void run()
            {
                int gid = getGlobalId();
                sum[gid] = a[gid] + b[gid];
            }
        };

        kernel.execute(Range.create(536870912));

        /*for(int i = 0; i < size; i++)
        {
            System.out.printf("%6.2f + %6.2f = %8.2f\n", a[i], b[i], sum[i]);
        }*/
        
        /*for(int i = 0; i < size; i++)
        {
            sum[i] = a[i] + b[i];
        }*/

        kernel.dispose();
    }
}