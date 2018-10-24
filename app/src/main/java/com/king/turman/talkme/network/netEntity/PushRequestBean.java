package com.king.turman.talkme.network.netEntity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by diaoqf on 2018/10/23.
 */

public class PushRequestBean {

    /**
     * platform : all
     * audience : all
     * notification : {"alert":"Hi,JPush !","android":{"extras":{"android-key1":"android-value1"}},"ios":{"sound":"sound.caf","badge":"+1","extras":{"ios-key1":"ios-value1"}}}
     */

    private String platform;
    private String audience;
    private NotificationBean notification;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public NotificationBean getNotification() {
        return notification;
    }

    public void setNotification(NotificationBean notification) {
        this.notification = notification;
    }

    public static class NotificationBean {
        /**
         * alert : Hi,JPush !
         * android : {"extras":{"android-key1":"android-value1"}}
         * ios : {"sound":"sound.caf","badge":"+1","extras":{"ios-key1":"ios-value1"}}
         */

        private String alert;
        private AndroidBean android;
        private IosBean ios;

        public String getAlert() {
            return alert;
        }

        public void setAlert(String alert) {
            this.alert = alert;
        }

        public AndroidBean getAndroid() {
            return android;
        }

        public void setAndroid(AndroidBean android) {
            this.android = android;
        }

        public IosBean getIos() {
            return ios;
        }

        public void setIos(IosBean ios) {
            this.ios = ios;
        }

        public static class AndroidBean {
            /**
             * extras : {"android-key1":"android-value1"}
             */

            private ExtrasBean extras;

            public ExtrasBean getExtras() {
                return extras;
            }

            public void setExtras(ExtrasBean extras) {
                this.extras = extras;
            }

            public static class ExtrasBean {
                /**
                 * android-key1 : android-value1
                 */

                @SerializedName("android-key1")
                private String androidkey1;

                public String getAndroidkey1() {
                    return androidkey1;
                }

                public void setAndroidkey1(String androidkey1) {
                    this.androidkey1 = androidkey1;
                }
            }
        }

        public static class IosBean {
            /**
             * sound : sound.caf
             * badge : +1
             * extras : {"ios-key1":"ios-value1"}
             */

            private String sound;
            private String badge;
            private ExtrasBeanX extras;

            public String getSound() {
                return sound;
            }

            public void setSound(String sound) {
                this.sound = sound;
            }

            public String getBadge() {
                return badge;
            }

            public void setBadge(String badge) {
                this.badge = badge;
            }

            public ExtrasBeanX getExtras() {
                return extras;
            }

            public void setExtras(ExtrasBeanX extras) {
                this.extras = extras;
            }

            public static class ExtrasBeanX {
                /**
                 * ios-key1 : ios-value1
                 */

                @SerializedName("ios-key1")
                private String ioskey1;

                public String getIoskey1() {
                    return ioskey1;
                }

                public void setIoskey1(String ioskey1) {
                    this.ioskey1 = ioskey1;
                }
            }
        }
    }
}
