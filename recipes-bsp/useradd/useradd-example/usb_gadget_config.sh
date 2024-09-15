#!/bin/sh
### BEGIN INIT INFO
# Provides:          usg_gadget_config
# Required-Start:
# Required-Stop:
# Default-Start:     S
# Default-Stop:
# Short-Description: Enable USB-Gadget mass-storage
### END INIT INFO

#modprobe g_mass_storage

g=/sys/kernel/config/usb_gadget/g1
mkdir ${g}

echo "0x1d6b" > ${g}/idVendor
echo "0x0104" > ${g}/idProduct

mkdir ${g}/strings/0x409
echo "12345678"    > ${g}/strings/0x409/serialnumber
echo "Foobar Inc." > ${g}/strings/0x409/manufacturer
echo "My Storage"  > ${g}/strings/0x409/product

mkdir ${g}/configs/c.1
mkdir ${g}/configs/c.1/strings/0x409
#echo <config> ${g}/configs/c.1/strings/0x409/configuration

mkdir ${g}/functions/mass_storage.0
echo "/dev/mmcblk0p3" > ${g}/functions/mass_storage.0/lun.0/file
ln -s ${g}/functions/mass_storage.0 ${g}/configs/c.1/

mkdir ${g}/functions/acm.GS0
ln -s ${g}/functions/acm.GS0 ${g}/configs/c.1/

ls /sys/class/udc > ${g}/UDC
/bin/start_getty 115200 ttyGS0 vt102 &

# show key face
ffmpeg -stream_loop -1 -i /media/kei.png -pix_fmt bgra -f fbdev /dev/fb0 -loglevel quiet &
