DESCRIPTION = "A minimal console image for Lichee Pi Nano"
LICENSE = "MIT"

IMAGE_INSTALL= "\
        base-files \
        base-passwd \
        busybox \
        sysvinit \
        initscripts \
        ${CORE_IMAGE_EXTRA_INSTALL} \
		useradd-example \
		sl \
		ffmpeg \
		dietsplash \
"

IMAGE_LINGUAS = " "

inherit core-image

IMAGE_ROOTFS_SIZE ?= "81920"