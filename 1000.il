.assembly extern mscorlib {}
.assembly '1000.fnt' {}

.class 'Single' extends [mscorlib]System.Object
{

.method static public void main () cil managed
{
	.locals (int32,int32,float64,int32,int32)
	.entrypoint
	.maxstack 2
	call string [mscorlib]System.Console::ReadLine()
	call bool [mscorlib]System.Boolean::Parse(string)
	stloc 1
// ------ IF --------
	ldloc 1
	ldc.i4.0
	beq L8
	call string [mscorlib]System.Console::ReadLine()
	call float64 [mscorlib]System.Double::Parse(string)
	stloc 2
	ldc.i4 0
	stloc 3
// ----- WHILE -----
L2:	ldloc 3
	ldc.i4 3
	blt L0
	ldc.i4.0
	br L1
L0:	ldc.i4.1
L1:	ldc.i4.0
	beq L3
	ldloc 2
	ldc.i4 1
	conv.r8
	add
	stloc 2
	ldc.i4 0
	stloc 4
// ----- WHILE -----
L6:	ldloc 4
	ldc.i4 4
	blt L4
	ldc.i4.0
	br L5
L4:	ldc.i4.1
L5:	ldc.i4.0
	beq L7
	call string [mscorlib]System.Console::ReadLine()
	call int32 [mscorlib]System.Int32::Parse(string)
	stloc 0
	ldloc 0
	call void [mscorlib]System.Console::WriteLine(int32)
	ldloc 4
	ldc.i4 1
	add
	stloc 4
	br L6
L7:// ---- END WHILE ----
	ldloc 3
	ldc.i4 1
	add
	stloc 3
	br L2
L3:// ---- END WHILE ----
L8:// ---- END IF ----
	ldloc 2
	call void [mscorlib]System.Console::WriteLine(float64)
	ret
}
}

