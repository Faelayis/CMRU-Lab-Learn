import time

t = time.time()
print(time.gmtime())
time.sleep(2)
print(time.localtime())
time.sleep(3)
print(time.asctime())

# NOTE: Output
# time.struct_time(tm_year=2024, tm_mon=2, tm_mday=13, tm_hour=2, tm_min=23, tm_sec=20, tm_wday=1, tm_yday=44, tm_isdst=0)
# time.struct_time(tm_year=2024, tm_mon=2, tm_mday=13, tm_hour=9, tm_min=23, tm_sec=22, tm_wday=1, tm_yday=44, tm_isdst=0)
# Tue Feb 13 09:23:25 2024
