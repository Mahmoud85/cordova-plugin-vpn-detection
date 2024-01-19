How to use

window.vpndetection.detectActiveVPN(successCallback,failureCallback)

Working Example




 checkForVPNDetection() {
   this.platform.ready().then(()=>{
    try {
      console.log("getting inside the function>>", window.VPNdetection)
      window.vpndetection.detectActiveVPN(
        successCallback => {
          console.log("successCallback", successCallback)
          // device has Active VPN // use JailBreak popUp temporarily
          if (successCallback) {
            let modal = this.modal.create("CustomPopupPage", { message: 'successCallback' }, { enableBackdropDismiss: false });
              modal.present();
          }
        },
        // failureCallback is called if there was an error determining if the device is Jailbroken
        failureCallback => {
          console.log("successCallback", failureCallback)
          this.alert.displayErrorToast(failureCallback);
          let modal = this.modal.create("CustomPopupPage", { message: 'failureCallback' }, { enableBackdropDismiss: true });
          modal.present();
        }
      );
    } catch (exp) {
    }
   })
  }

Credit
 By Mahmoud Bakhit 2024




