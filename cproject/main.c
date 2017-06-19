#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[] = {87,-67,35,7,4,-34,765,-34,6,5,-4,6,43,-87,76};
    int b = maxsubsum(a,0,sizeof(a)/sizeof(int));
    b=3;
    printf("b %d",b);
    return 0;
}

int maxsubsum( const int a[],int left,int right )
{
    int maxleft,maxright;
    int subleft,subright;
    int maxsubleft,maxsubright;
    int center,i;
    if(left==right)
        if(a[left]>0)
            return a[left];
        else
            return 0;
    center = (left+right)/2;
    maxleft = maxsubsum(a,left,center);
    maxright = maxsubsum(a,center,right);
    subleft=0;
    subright=0;
    for( i=center; i>=left; i--)
    {
        subleft+=a[i];
        if(subleft>maxsubleft)
            maxsubleft=subleft;
    }
    for( i=center; i<=right; i++)
    {
        subright+=a[i];
        if(subright>maxsubright)
            maxsubright = subright;

    }
    return maxsubthree(maxleft,maxright,(maxsubleft+maxsubright));

}

int maxsubthree(int a,int b,int c)
{
    return a >b?(a>c?a:c):(b>c?b:c);
}
