#!/bin/sh

ffmpeg -f lavfi -i testsrc=duration=10:size=320x240:rate=30 -pix_fmt bgra -f fbdev /dev/fb0
ffmpeg -i /media/key.png -vcodec rawvideo -f rawvideo -pix_fmt bgra -f /dev/fb0
ffmpeg -f lavfi -i /media/key.png -pix_fmt bgra -f fbdev /dev/fb0
