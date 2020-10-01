a=int(input("Enter Seconds"))
hrs=0
m=0
t=0
s=0
hrs=int(a/3600)
t=int(a%3600)
m=int(t/60)
s=int(t%60)

print("hrs=",hrs,"min=",m,"secs=",s) 
