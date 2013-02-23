.assembly extern mscorlib {}
.assembly '1000_mod.fnt' {}
.class 'Single' extends [mscorlib]System.Object 
{
.method static public void main () cil managed 
{
.locals()
.entrypoint
.maxstack 1000
ldc.i4 3
ldc.i4 2
add
ldc.i4 5
ceq
call void [mscorlib]System.Console::WriteLine(int32)

ldc.i4 3
ldc.i4 2
mul
ldc.i4 5
add
ldc.i4 6
ceq
not
call void [mscorlib]System.Console::WriteLine(int32)

ldc.i4 3
ldc.i4 2
mul
ldc.i4 3
ldc.i4 5
mul
add
ldc.i4 3
sub
ldc.i4 0
clt
ldc.i4 3
ldc.i4 2
add
ldc.i4 5
sub
ldc.i4 0
cgt
add
ldc.i4 0
ceq
not
call void [mscorlib]System.Console::WriteLine(int32)


 ret
}
}
