
#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <signal.h>
#include <sys/stat.h>

int f;
char *programa;

void SeAcabo(int i)
{
  kill(f,SIGKILL);
  printf("MATA matando... %s\n",programa);
  exit(-1);
}
void Salir(int i)
{exit(1);}

void ComprobarPrograma(void)
{
   struct stat s;
   
   stat(programa,&s);
   if (!(s.st_mode & S_IEXEC))
   {
      printf("Error(MATA): '%s' no es ejecutable\n",programa);
      exit(-1);
   }
}

main(int argc,char *argv[])
{
  if (argc < 3)
      exit(1);

  programa = argv[2];
  /* Comentado porque no funciona con ilrun: */
  /* ComprobarPrograma(); */
  signal(SIGALRM,SeAcabo);
  signal(SIGCHLD,Salir);
  alarm(atoi(argv[1]));

  if ((f = fork()) == 0)
  	execvp(argv[2],&argv[2]);
  
  if (f != -1)
	while(1);
}
