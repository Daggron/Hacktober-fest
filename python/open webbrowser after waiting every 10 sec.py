import time
import webbrowser
i = 0
while(i < 3):
    print("Current time is ", time.ctime())
    time.sleep(10)
    webbrowser.open("https://www.youtube.com/")
    i += 1
