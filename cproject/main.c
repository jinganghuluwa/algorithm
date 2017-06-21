#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[] = {1,-2,3,4,-5,6};
    int b = maxsubsum(a,0,sizeof(a)/sizeof(int));
    printf("result:%d",b);
    return 0;
}

int maxsubsum( const int a[],int left,int right )
{

    int maxleft,maxright;
    int subleft,subright;
    int maxsubleft=0,maxsubright=0;
    int center,i;
    if(left==right)
    {
        //printf("left:%d,right:%d a[left]:%d\r\n",left,right,a[left]);
        if(a[left]>0)
        {
            return a[left];
        }
        else
        {
            return 0;
        }
    }

    center = (left+right)/2;
    maxleft = maxsubsum(a,left,center);
    maxright = maxsubsum(a,center+1,right);
    subleft=0;
    subright=0;
    for( i=center; i>=left; i--)
    {
        subleft+=a[i];
        if(subleft>maxsubleft)
        {
            maxsubleft=subleft;
        }
    }
    for( i=center+1; i<=right; i++)
    {
        subright+=a[i];
        if(subright>maxsubright)
        {
            maxsubright = subright;
        }

    }
    printf("left: %d,right: %d,maxleft:%d,maxright:%d,maxsubleft:%d,maxsubright:%d\r\n",left,right,maxleft,maxright,maxsubleft,maxsubright);
    return maxsubthree(maxleft,maxright,(maxsubleft+maxsubright));

}

int maxsubthree(int a,int b,int c)
{
    return a >b?(a>c?a:c):(b>c?b:c);
}
